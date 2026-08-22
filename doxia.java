package com.example.doxia.antlr;

import org.apache.maven.doxia.sink.Sink;

public class DoxiaEmitterListener extends DocLanguageBaseListener {
    private final Sink sink;

    public DoxiaEmitterListener(Sink sink) {
        this.sink = sink;
    }

    @Override
    public void enterHeader(DocLanguageParser.HeaderContext ctx) {
        sink.section1();
        sink.sectionTitle1();
        sink.text(ctx.TEXT().getText().trim());
        sink.sectionTitle1_();
    }

    @Override
    public void exitHeader(DocLanguageParser.HeaderContext ctx) {
        sink.section1_();
    }

    @Override
    public void enterParagraph(DocLanguageParser.ParagraphContext ctx) {
        sink.paragraph();
        sink.text(ctx.TEXT().getText().trim());
        sink.paragraph_();
    }
}
