package br.com.rabbithole.lobbybundle.auth.data.sql.methods;

import br.com.rabbithole.lobbybundle.auth.cryptography.SHA256;
import br.com.rabbithole.lobbybundle.auth.data.sql.tables.AuthTable;

import java.util.UUID;

public class AuthMethods {
    public static boolean createAccount(String nick, UUID uuid, String password, String firstIp) {
        try (AuthTable acccount = new AuthTable(nick, uuid.toString(), SHA256.encrypt(password), firstIp)) {
            if (!acccount.find()) return acccount.insert();
        }
        return false;
    }

    public static boolean hasAccount(String nick) {
        try (AuthTable account = new AuthTable(nick)) {
            return account.find();
        }
    }

    public static boolean updateAccount(String nick) { //TODO: NÃO IMPLEMENTAR ESSE MÉTODO
        return false;
    }

    public static boolean deleteAccount(String nick) {
        try (AuthTable account = new AuthTable(nick)) {
            if (account.find()) return account.delete();
        }
        return false;
    }

    public static boolean checkIp(String nick, String ip) {
        return false;
    }
}
