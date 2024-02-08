package exercise;

// BEGIN
    public class LabelTag implements TagInterface {
        private TagInterface tag;
        private String value = "";

        public LabelTag(String value, TagInterface tag) {
            this.value = value;
            this.tag = tag;
        }

        @Override
        public String render() {
            return "<label>" + value + tag.render() + "</label>";
        }
}
// END
