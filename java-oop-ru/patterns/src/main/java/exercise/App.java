package exercise;

public class App {
    public static void main(String[] args) {
        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        System.out.println(labelTag.render());
        // <label>Press Submit<input type="submit" value="Save"></label>
        // <label>Press Submit<input type="submit" value="Save"></label>

    }
}
