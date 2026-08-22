package com.example.doxia;

import org.apache.maven.doxia.parser.AbstractTextParser;
import org.apache.maven.doxia.parser.ParseException;
import org.apache.maven.doxia.sink.Sink;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.Reader;

@Named("custom")
@Singleton
public class CustomParser extends AbstractTextParser {

    @Override
    public void parse(Reader reader, Sink sink) throws ParseException {
        try (BufferedReader in = new BufferedReader(reader)) {
            // Initiate document structure
            sink.head();
            sink.title();
            sink.text("Generated Custom Document");
            sink.title_();
            sink.head_();

            sink.body();

            String line;
            while ((line = in.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("# ")) {
                    // Map '# Heading' to Doxia sectionTitle1
                    sink.section1();
                    sink.sectionTitle1();
                    sink.text(line.substring(2));
                    sink.sectionTitle1_();
                    sink.section1_();
                } else if (!line.isEmpty()) {
                    // Map plain text lines to paragraphs
                    sink.paragraph();
                    sink.text(line);
                    sink.paragraph_();
                }
            }

            sink.body_();
            sink.flush();
        } catch (Exception e) {
            throw new ParseException("Failed to parse custom document", e);
        }
    }
}
