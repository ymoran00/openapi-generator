package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.parameters.Parameter;

import java.io.File;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsharpNetcoreFunctionsServerCodegen extends CSharpNetCoreReducedClientCodegen  {
    public static final String PROJECT_NAME = "projectName";

    final Logger LOGGER = LoggerFactory.getLogger(CsharpNetcoreFunctionsServerCodegen.class);

    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    public String getName() {
        return "csharp-netcore-functions";
    }

    public String getHelp() {
        return "Generates a csharp server.";
    }

    public CsharpNetcoreFunctionsServerCodegen() {
        super();
        outputFolder = "generated-code" + File.separator + "csharp";
        modelTemplateFiles.put("model.mustache", ".cs");
        apiTemplateFiles.put("functions.mustache", ".cs");
        embeddedTemplateDir = templateDir = "csharp-netcore-functions";
        apiPackage = "Apis";
        modelPackage = "Models";
        String clientPackageDir = "generatedSrc/Client";
        supportingFiles.add(new SupportingFile("README.mustache", "generatedSrc", "README.md"));
        supportingFiles.add(new SupportingFile("project.mustache", "generatedSrc", "project.json"));
        
        supportingFiles.add(new SupportingFile("IApiAccessor.mustache",
                clientPackageDir, "IApiAccessor.cs"));
        supportingFiles.add(new SupportingFile("Configuration.mustache",
                clientPackageDir, "Configuration.cs"));
        supportingFiles.add(new SupportingFile("ApiClient.mustache",
                clientPackageDir, "ApiClient.cs"));
        supportingFiles.add(new SupportingFile("ApiException.mustache",
                clientPackageDir, "ApiException.cs"));
        supportingFiles.add(new SupportingFile("ApiResponse.mustache",
                clientPackageDir, "ApiResponse.cs"));
        supportingFiles.add(new SupportingFile("ExceptionFactory.mustache",
                clientPackageDir, "ExceptionFactory.cs"));
        supportingFiles.add(new SupportingFile("OpenAPIDateConverter.mustache",
                clientPackageDir, "OpenAPIDateConverter.cs"));
    }

    @Override
    public String apiFileFolder() {
        return outputFolder + File.separator + "generatedSrc" + File.separator + "Functions";
    }

    @Override
    public String modelFileFolder() {
        return outputFolder + File.separator + "generatedSrc" + File.separator +  "Models";
    }

    @Override
    public String apiDocFileFolder() {
        return (outputFolder + "/Docs").replace('/', File.separatorChar);
    }

    @Override
    public String apiTestFileFolder() {
        return outputFolder + File.separator + "Tests" + File.separator + "Tests" + File.separator + apiPackage();
    }

}
