package com.skypro.library.checkIsbn;

public class ISBN {
    private String isbn = null;
    protected ISBN(String isbn) {
        isbn = isbn.trim().replaceAll("-", "");
        this.isbn = isbn;
    }
    protected static ISBN parse(String isbn) {
        isbn = isbn.trim().replaceAll("-", "").replaceAll(" ", "");
        if (isbn.length() == 13)
            return new ISBN13(isbn);
        if (isbn.length() == 10)
            return new ISBN10(isbn);
        throw new IllegalArgumentException(
                "Not a valid ISBN number (invalid length) : " + isbn);
    }
    public String getIsbn() {
        return isbn;
    }

    public static boolean isValid(String isbn) {
        ISBN i = parse(isbn);
        return i.checkSum() == 0;
    }
    public static String toISBN10(String isbn) {

        if (!isValid(isbn))
            throw new IllegalArgumentException("The ISBN number is not valid");

        ISBN i = ISBN.parse(isbn);

        if (i instanceof ISBN10) {
            return i.getIsbn();
        }

        return new ISBN10(isbn.substring(3, 12)
                + ISBN10.parse(isbn.substring(3, 12) + "0").checkSum())
                .getIsbn();

    }

    public static String toISBN13(String isbn) {
        if (!isValid(isbn))
            throw new IllegalArgumentException("The ISBN number is not valid");

        ISBN i = ISBN.parse(isbn);

        if (i instanceof ISBN13) {
            return i.getIsbn();
        }

        int checkSum = ISBN13.parse(ISBN13.SUFFIX + isbn.substring(0, 9) + "0")
                .checkSum();
        String s_checkSum = checkSum < 10 ? String.valueOf(checkSum) : "x";

        return new ISBN13(ISBN13.SUFFIX + isbn.substring(0, 9) + s_checkSum)
                .getIsbn();
    }

    public int checkSum() {
        return 0;
    }

}
