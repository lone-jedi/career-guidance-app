package com.yarkin.careerguidance.templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;


public class PageGenerator {
    private static final String HTML_DIR = "src/main/webapp/src";

    private static PageGenerator pageGenerator;
    private final Configuration cfg;

    public static PageGenerator instance() {
        if (pageGenerator == null)
            pageGenerator = new PageGenerator();
        return pageGenerator;
    }

    public String getPage(String filename, Map<String, Object> data) {
        Writer stream = new StringWriter();
        try {
            Template template = cfg.getTemplate(HTML_DIR + File.separator + filename);
            nullValuesToEmptyString(data);
            template.process(data, stream);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        return stream.toString();
    }

    public void nullValuesToEmptyString(Map<String, Object> data) {
        data.replaceAll((key, value) -> value == null ? "" : value);
    }

    private PageGenerator() {
        cfg = new Configuration();
    }
}
