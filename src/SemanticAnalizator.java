import java.util.LinkedList;

public class SemanticAnalizator {
    static class Entry {
        private String value;
        private int position;
        public Entry(String v, int p){
            value = v;
            position = p;
        }
    }

    private static LinkedList<Entry> identifiers = new LinkedList<>();
    private static LinkedList<Entry> constants = new LinkedList<>();

    public static void clear() {
        identifiers.clear();
        constants.clear();
    }

    public static boolean isReserved(String s) {
        return s.equals("def") || s.equals("int") || s.equals("float") ||
                s.equals("set") || s.equals("return");
    }

    public static void addIdentifiers(String name, int pos) {
        for (Entry e : identifiers) {
            if (e.value.equals(name)) return;
        }
        identifiers.add(new Entry(name, pos));
    }

    public static void addConstant(String value, int pos) {
        for (Entry e : constants) {
            if (e.value.equals(value)) return;
        }
        constants.add(new Entry(value, pos));
    }

    public static String getTablesString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- ИДЕНТИФИКАТОРЫ ---\n");
        for (Entry i : identifiers) {
            sb.append("Имя: ").append(i.value).append(" | Позиция: ").append(i.position).append("\n");
        }
        sb.append("\n--- КОНСТАНТЫ ---\n");
        for (Entry c : constants) {
            sb.append("Значение: ").append(c.value).append(" | Позиция: ").append(c.position).append("\n");
        }
        return sb.toString();
    }
}