package ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    final private Scanner console = new Scanner(System.in);

    /**
     *
     * @param msg
     */
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    /**
     * @param prompt
     * @return
     */

    @Override
    public String readDouble(String prompt) {
        while (true) {
            try {
                return String.valueOf(Double.parseDouble(this.readString(prompt)));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */

    @Override
    public double readDouble(String prompt, double min, double max) {
        double result;
        do {
            result = Double.parseDouble(readDouble(prompt));
        } while (result < min || result > max);
        return result;
    }

    /**
     *
     * @param prompt
     * @return
     */

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }

    /**
     *
     * @param prompt
     * @return
     */

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                // print the message prompt
                String stringValue = this.readString(prompt);
                // Get the input line, and try and parse
                num = Integer.parseInt(stringValue); // if it's 'bob' it'll break
                invalidInput = false; // or you can use 'break;'
            } catch (NumberFormatException e) {
                // If it explodes, it'll go here and do this.
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    /**
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }

    /**
     *
     * @param prompt
     * @return
     */

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    /**
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

    /**
     *
     * @param prompt
     * @return
     */

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }
}
