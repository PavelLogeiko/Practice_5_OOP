public class CsvWriter implements Format{
    @Override
    public <T extends Contact> String createString(T contact) {
        return String.format("%d,%s,%s,%s,%s,%s\n",contact.getId(), contact.getPersonLastName(), contact.getPersonFirstName(),
                contact.getNumber(), contact.getPriority(), contact.getComment());
    }
}