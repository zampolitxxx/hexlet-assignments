package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(super.getTagName());
        for(Map.Entry<String, String> me : super.getAttributes().entrySet()) {
            sb.append(" " + me.getKey() + "=\"" + me.getValue() + "\"");
        }
        return sb.append(">").toString();
    }
}
//"img", Map.of("class", "v-10", "id", "wop")
//<img class="v-10" id="wop">
// END
