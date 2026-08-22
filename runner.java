// Java Implementation: Programmatic Doxia Parser & Sink API
import org.apache.maven.doxia.module.xdoc.XdocParser;
import org.apache.maven.doxia.module.xhtml5.Xhtml5SinkFactory;
import org.apache.maven.doxia.sink.Sink;

import java.io.FileReader;
import java.io.FileWriter;

public class DoxiaRunner {
    public static void main(String[] args) throws Exception {
        XdocParser parser = new XdocParser();

        try (FileReader input = new FileReader("src/site/xdoc/index.xml");
             FileWriter output = new FileWriter("target/site/index.html")) {

            // Create an event-driven HTML5 Sink
            Sink sink = new Xhtml5SinkFactory().createSink(output);

            // Stream markup events from input to sink target
            parser.parse(input, sink);
            sink.close();
        }
    }
}
