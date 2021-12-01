package com.yarkin.careerguidance.utils.templater;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageGeneratorTest {
    private static final String PATH_TO_RESOURCES = "src/test/resources";

    @BeforeAll
    public static void initialize() throws IOException {
        File resourceDirectory = new File(PATH_TO_RESOURCES);
        resourceDirectory.mkdirs();

        File htmlFile = new File(resourceDirectory, "test.html");
        htmlFile.createNewFile();

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(htmlFile))
        )) {
            writer.write("<html><head></head><body><h1>Test Servlet</h1></body></html>");
        }
    }

    @Test
    public void getContentFromFileWithoutTemplateParameters() {
        String expected = "<html><head></head><body><h1>Test Servlet</h1></body></html>";
        String actual = PageGenerator.instance().getPageFromPath(Paths.get(PATH_TO_RESOURCES,
                "test.html"));
        assertEquals(expected, actual);
    }
}