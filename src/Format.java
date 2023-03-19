public interface Format { //интерфейс создания строк для записи в файл
    <T extends Contact> String createString(T contact);
}

