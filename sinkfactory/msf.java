package com.example.doxia;

import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.doxia.sink.impl.AbstractSinkFactory;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.Writer;

@Named("markdown")
@Singleton
public class MarkdownSinkFactory extends AbstractSinkFactory {
    @Override
    protected Sink createSink(Writer writer, String encoding) {
        return new MarkdownSink(writer);
    }
}
