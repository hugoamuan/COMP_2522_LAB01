package ca.bcit.comp2522.bank;

public class Main {
    public static void main(String[] args) {
        // Create Date objects
        Date einsteinBirth = new Date(1879, 3, 14); // March 14, 1879
        Date einsteinDeath = new Date(1955, 4, 18); // April 18, 1955
        Date einsteinSignup = new Date(1900, 1, 1); // January 1, 1900
        Date einsteinClosure = new Date(1950, 10, 14); // October 14, 1950

        Date mandelaBirth = new Date(1918, 7, 18); // July 18, 1918
        Date mandelaDeath = new Date(2013, 12, 5); // December 5, 2013
        Date mandelaSignup = new Date(1994, 5, 10); // May 10, 1994

        Date kahloBirth = new Date(1907, 7, 6); // July 6, 1907
        Date kahloDeath = new Date(1954, 7, 13); // July 13, 1954
        Date kahloSignup = new Date(1940, 1, 1); // January 1, 1940

        Date chanBirth = new Date(1954, 4, 7); // April 7, 1954
        Date chanSignup = new Date(1980, 10, 1); // October 1, 1980


        // Create Name and Person objects
        Name einsteinName = new Name("Albert", "Einstein");
        Person einstein = new Person(einsteinName, einsteinBirth, einsteinDeath);
        BankClient einsteinClient = new BankClient(einsteinName, "abc123", einsteinSignup, einsteinBirth, einsteinDeath);
        BankAccount einsteinAccount = new BankAccount(einsteinClient, "abc123", 3141, einsteinSignup, einsteinClosure);

        // Print details for Albert Einstein
        System.out.println("Albert Einstein:");
        System.out.println("Initials: " + einsteinName.getInitials());
        System.out.println("Full Name: " + einsteinName.getFullName());
        System.out.println("Reversed Name: " + einsteinName.getReversedName());
        System.out.println("Person Details: " + einstein.getDetails());
        System.out.println("BankClient Details: " + einsteinClient.getDetails());
        System.out.println("BankAccount Balance: $" + einsteinAccount.getBalance());

        // Perform deposit and withdrawal operations if the account is open
        try {
            einsteinAccount.deposit(1000, 3141);
            einsteinAccount.withdraw(100, 3141);
            System.out.println("BankAccount Balance after Withdrawal: $" + einsteinAccount.getBalance());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }

        // Create BankAccount for Nelson Mandela
        Name mandelaName = new Name("Nelson", "Mandela");
        Person mandela = new Person(mandelaName, mandelaBirth, mandelaDeath);
        BankClient mandelaClient = new BankClient(mandelaName, "654321", mandelaSignup, mandelaBirth, mandelaDeath);
        BankAccount mandelaAccount = new BankAccount(mandelaClient, "654321", 4664, mandelaSignup);

        // Print details for Nelson Mandela
        System.out.println("\nNelson Mandela:");
        System.out.println("Initials: " + mandelaName.getInitials());
        System.out.println("Full Name: " + mandelaName.getFullName());
        System.out.println("Reversed Name: " + mandelaName.getReversedName());
        System.out.println("Person Details: " + mandela.getDetails());
        System.out.println("BankClient Details: " + mandelaClient.getDetails());
        System.out.println("BankAccount Balance: $" + mandelaAccount.getBalance());

        // Perform deposit and withdrawal operations
        try {
            mandelaAccount.deposit(2000, 4664);
            mandelaAccount.withdraw(200, 4664);
            System.out.println("BankAccount Balance after Withdrawal: $" + mandelaAccount.getBalance());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }

        // Create BankAccount for Frida Kahlo
        Name kahloName = new Name("Frida", "Kahlo");
        Person kahlo = new Person(kahloName, kahloBirth, kahloDeath);
        BankClient kahloClient = new BankClient(kahloName, "frd123", kahloSignup, kahloBirth, kahloDeath);
        BankAccount kahloAccount = new BankAccount(kahloClient, "frd123", 1907, kahloSignup, kahloDeath);

        // Print details for Frida Kahlo
        System.out.println("\nFrida Kahlo:");
        System.out.println("Initials: " + kahloName.getInitials());
        System.out.println("Full Name: " + kahloName.getFullName());
        System.out.println("Reversed Name: " + kahloName.getReversedName());
        System.out.println("Person Details: " + kahlo.getDetails());
        System.out.println("BankClient Details: " + kahloClient.getDetails());
        System.out.println("BankAccount Balance: $" + kahloAccount.getBalance());

        // Perform deposit and withdrawal operations
        try {
            kahloAccount.deposit(500, 1907);
            kahloAccount.withdraw(50, 1907);
            System.out.println("BankAccount Balance after Withdrawal: $" + kahloAccount.getBalance());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }

        // Create BankAccount for Jackie Chan
        Name chanName = new Name("Jackie", "Chan");
        Person chan = new Person(chanName, chanBirth);
        BankClient chanClient = new BankClient(chanName, "chan789", chanSignup, chanBirth);
        BankAccount chanAccount = new BankAccount(chanClient, "chan789", 1954, chanSignup);

        // Print details for Jackie Chan
        System.out.println("\nJackie Chan:");
        System.out.println("Initials: " + chanName.getInitials());
        System.out.println("Full Name: " + chanName.getFullName());
        System.out.println("Reversed Name: " + chanName.getReversedName());
        System.out.println("Person Details: " + chan.getDetails());
        System.out.println("BankClient Details: " + chanClient.getDetails());
        System.out.println("BankAccount Balance: $" + chanAccount.getBalance());

        // Perform deposit and withdrawal operations
        try {
            chanAccount.deposit(3000, 1954);
            chanAccount.withdraw(500, 1954);
            System.out.println("BankAccount Balance after Withdrawal: $" + chanAccount.getBalance());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }
}
