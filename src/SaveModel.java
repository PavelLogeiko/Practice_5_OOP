public class SaveModel <T  extends Contact> {
    Format format;
    String text;
    String path;
    T contact;
    public SaveModel(T contact) {
        this.contact = contact;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void save() {
        text = format.createString(contact);
        Saver.saveFile(text, this.path);
    }
}