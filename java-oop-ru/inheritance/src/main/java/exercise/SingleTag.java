package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        return "<" + super.getTagName();
    }
}
//"img", Map.of("class", "v-10", "id", "wop")
//<img class="v-10" id="wop">
// END
