package gr.huadit.Handlers;

public class InputHelper {
    
    public InputHelper() {

    }; 

    public boolean getValidInInput(String promt) {
        if (promt == null || promt.trim().isEmpty()) {
            return false;
        }
        try { 
            Double.parseDouble(promt);
            return true;
        } catch (NumberFormatException e) { 
            return false; 
        }
    } 
    public boolean getValidStringInput(String input) {
        return input != null && !input.trim().isEmpty();
    }
} 