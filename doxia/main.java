// Main.java - Wiring a Doxia Parser to the Custom Markdown Sink
package com.example.doxia;

import org.apache.maven.doxia.module.xdoc.XdocParser;
import org.apache.maven.doxia.parser.Parser;

import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Parser parser = new XdocParser();

        try (FileReader reader = new FileReader("src/site/xdoc/index.xml");
             FileWriter writer = new FileWriter("target/output.md")) {

            // Instantiate custom Markdown Sink
            MarkdownSink sink = new MarkdownSink(writer);

            // Parse document: events stream directly into MarkdownSink callbacks
            parser.parse(reader, sink);

            sink.flush();
            sink.close();
        }
    }
}
