import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeVisitor;

/**
 * Created by naco_siren on 3/23/17.
 */
public class APTEDNodeVisitor implements NodeVisitor {
    @Override
    public void head(Node node, int depth) {
//        if (node instanceof Element)
//            System.out.println("Enter Element: " + ((Element) node).tag() + ", " + depth);
//        else
//            System.out.println("Enter Text: " + ((TextNode) node).text() + ", " + depth);
    }

    @Override
    public void tail(Node node, int depth) {

        if (node instanceof Element) {
            Element element = (Element) node;

            /* Adding its children's apt string to it */
            StringBuilder stringBuilder = new StringBuilder("{" + element.tagName());
            for (Element child : element.children()){
                stringBuilder.append(child.APTEDTreeStructure);
                element.numOffSpring += child.numOffSpring;
            }
            stringBuilder.append("}");

            element.APTEDTreeStructure = stringBuilder.toString();

        }
    }
}
