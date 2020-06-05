package com.yk.tech.piglatin;

import com.yk.tech.piglatin.core.PigLatinTranslator;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        final PigLatinTranslator pigLatinTranslator = PigLatinTranslator.defaultInstance();
        final String inputText = readText();
        LOGGER.info("Input text:\n{}\n\n", inputText);

        final String translatedText = pigLatinTranslator.translateText(inputText);
        LOGGER.info("Translated text:\n{}\n\n", translatedText);
    }

    private static String readText() {
        final InputStream is = Main.class.getClassLoader().getResourceAsStream("texts/text1.txt");
        if (is == null) {
            throw new RuntimeException("Demo file is not found.");
        }

        try {
            return IOUtils.toString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read a demo file.", e);
        }
    }
}
