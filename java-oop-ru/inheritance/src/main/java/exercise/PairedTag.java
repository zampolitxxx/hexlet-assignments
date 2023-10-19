package exercise;

import java.util.List;
import java.util.Map;
import java.lang.StringBuilder;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> childTags;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> childTags) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.childTags = childTags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(super.getTagName());
        for(Map.Entry<String, String> me : super.getAttributes().entrySet()) {
            sb.append(" " + me.getKey() + "=\"" + me.getValue() + "\"");
        }
        sb.append(">");
        for(Tag st : childTags) {
            sb.append(st.toString());
        }
        sb.append(tagBody);
        return sb.append("</" + super.getTagName() + ">").toString();
    }
}
//<div class="y-5"><br id="s"><hr class="a-5"></div>
// END
