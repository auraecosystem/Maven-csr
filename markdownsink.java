// MarkdownSink.java - Custom Doxia Sink extending AbstractTextSink
package com.example.doxia;

import org.apache.maven.doxia.sink.impl.AbstractTextSink;
import java.io.PrintWriter;
import java.io.Writer;

public class MarkdownSink extends AbstractTextSink {
    private final PrintWriter writer;

    public MarkdownSink(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    // --- Headers ---
    @Override
    public void sectionTitle1() { writer.print("# "); }
    @Override
    public void sectionTitle1_() { writer.println("\n"); }

    @Override
    public void sectionTitle2() { writer.print("## "); }
    @Override
    public void sectionTitle2_() { writer.println("\n"); }

    @Override
    public void sectionTitle3() { writer.print("### "); }
    @Override
    public void sectionTitle3_() { writer.println("\n"); }

    // --- Text Blocks & Paragraphs ---
    @Override
    public void paragraph_() { writer.println("\n"); }

    // --- Inline Formatting ---
    @Override
    public void bold() { writer.print("**"); }
    @Override
    public void bold_() { writer.print("**"); }

    @Override
    public void italic() { writer.print("*"); }
    @Override
    public void italic_() { writer.print("*"); }

    @Override
    public void inline() { }
    @Override
    public void inline_() { }

    // --- Lists ---
    @Override
    public void listItem() { writer.print("* "); }
    @Override
    public void listItem_() { writer.println(); }
    @Override
    public void list_() { writer.println(); }

    // --- Content Emitting ---
    @Override
    public void text(String text) {
        writer.print(text);
    }

    @Override
    public void flush() {
        writer.flush();
    }

    @Override
    public void close() {
        writer.close();
    }
}
