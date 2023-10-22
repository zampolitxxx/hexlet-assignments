package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<SingleTag> childTags;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<SingleTag> childTags) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.childTags = childTags;
    }
}
// END
