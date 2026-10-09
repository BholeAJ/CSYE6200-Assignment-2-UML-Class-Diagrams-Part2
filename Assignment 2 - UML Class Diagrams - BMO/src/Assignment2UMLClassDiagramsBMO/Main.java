/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author AJIT BHOLE
 */
package Assignment2UMLClassDiagramsBMO;

public class Main {

    static BMOBank bank;

    
    static Individual individual(String id, String name, String sin) {
        return new Individual(id, name, 0, bank.getProgram(), bank, sin, "Engineer", 85000.0, "employed");
    }
    static Student student(String id, String name) {
        return new Student(id, name, 0, bank.getProgram(), bank, "UofT", "S1001", 2028);
    }
    static SmallBusiness smallBusiness(String id, String name, String sin) {
        return new SmallBusiness(id, name, 0, bank.getProgram(), bank, sin, "Owner", "Corner Shop Inc", 6);
    }
    static Investor investor(String id, String name, String sin) {
        return new Investor(id, name, 0, bank.getProgram(), bank, sin, "Trader", "aggressive", 250000.0);
    }
    static LargeBusiness largeBusiness(String id, String name, String sin) {
        return new LargeBusiness(id, name, 0, bank.getProgram(), bank, sin, "CEO", "MapleCorp Ltd", 90000000.0, "Retail");
    }
    static Minor minor(String id, String name) {
        return new Minor(id, name, 0, bank.getProgram(), bank, "Ann", 50.0);
    }
    static OtherBankClient otherBankClient(String id, String name) {
        return new OtherBankClient(id, name, 0, bank.getProgram(), "RBC", "RBC-889");
    }
    static SavingsAccount savings(String no, String nick, double rate, BMOClient owner) {
        return new SavingsAccount(no, 0.0, bank, nick, rate, owner);
    }
    static CheqingAccount cheqing(String no, String nick, BMOClient owner) {
        return new CheqingAccount(no, 4.95, bank, nick, 500.0, owner);
    }
    static InvestmentAccount investment(String no, String nick, BMOClient owner) {
        return new InvestmentAccount(no, 5.0, bank, nick, "TFSA", 18000.0, owner);
    }
    static LoanAccount loan(String no, double rate, BMOClient owner) {
        return new LoanAccount(no, 10.0, bank, rate, owner);
    }
    static Reward reward(String name, int cost) {
        return new Reward(name, cost, bank.getProgram());
    }
    // =====================================================================

    static void title(String s) {
        System.out.println("\n=== " + s + " ===");
    }

    public static void main(String[] args) {

        title("1. Create the bank (it creates its loyalty program)");
        bank = new BMOBank();
        System.out.println("Bank created. Program exists: " + (bank.getProgram() != null));

        title("2. Create clients (all types)");
        Individual ann = individual("C1", "Ann", "111-222-333");
        Student sam = student("C2", "Sam");
        SmallBusiness shop = smallBusiness("C3", "Corner Shop", "444-555-666");
        Investor raj = investor("C4", "Raj", "777-888-999");
        LargeBusiness corp = largeBusiness("C5", "MapleCorp", "000-111-222");
        Minor kid = minor("C6", "Kid");
        OtherBankClient olga = otherBankClient("X1", "Olga");
        System.out.println("BMO clients:");
        bank.listClients();
        System.out.println("BMO clients: " + bank.numberOfClients());
        System.out.println("Loyalty members (incl. other banks): " + bank.getProgram().numberOfMembers());

        title("3. Create accounts");
        SavingsAccount sav = savings("1001", "Rainy day", 2.5, ann);
        CheqingAccount chq = cheqing("1002", "Daily", ann);
        InvestmentAccount inv = investment("2001", "TFSA", raj);
        LoanAccount loan = loan("3001", 5.4, corp);
        System.out.println("Bank accounts:");
        bank.listAccounts();
        System.out.println("Monthly fee of cheqing 1002: $" + chq.getMonthlyFee());

        title("4. Joint ownership (account has 1..4 owners)");
        System.out.println("Add Sam to savings:   " + sav.addOwner(sam));
        System.out.println("Add shop to savings:  " + sav.addOwner(shop));
        System.out.println("Add Raj to savings:   " + sav.addOwner(raj));
        System.out.println("Add Corp (5th owner): " + sav.addOwner(corp) + "   <-- false = multiplicity violation");
        sav.listOwners();

        title("5. Removing owners");
        System.out.println("Remove Raj from savings: " + sav.removeOwner(raj));
        System.out.println("Remove Ann from cheqing (only owner): " + chq.removeOwner(ann)
                + "   <-- false = would leave 0 owners");
        chq.listOwners();

        title("6. A client lists their accounts");
        ann.listAccounts();
        sam.listAccounts();

        title("7. Unique account number");
        try {
            cheqing("1001", "Duplicate", sam);
            System.out.println("No error (remove the word 'unique' check or see note)");
        } catch (RuntimeException e) {
            System.out.println("Error caught: " + e.getMessage());
        }

        title("8. Loyalty program: rewards");
        Reward coffee = reward("Free coffee", 50);
        Reward flight = reward("Flight voucher", 5000);
        System.out.println("Rewards:");
        bank.getProgram().listRewards();

        title("9. Earn points and redeem (Redemption association class)");
        ann.earnPoints(120);
        System.out.println("Ann points: " + ann.getPoints());
        ann.addRedemption(java.sql.Date.valueOf("2026-10-09"), coffee);
        olga.addRedemption(java.sql.Date.valueOf("2026-10-09"), coffee);
        ann.listRedemptions();
        coffee.listRedemptions();

        title("10. Loyalty members");
        System.out.println("Members:");
        bank.getProgram().listMembers();

        title("11. Remove an account");
        System.out.println("bank.removeAccount(loan): " + bank.removeAccount(loan)
                + "   <-- false = an account must always belong to a bank (multiplicity 1)");
        loan.delete();   // deleting the account object itself removes it everywhere
        System.out.println("After loan.delete(), bank accounts:");
        bank.listAccounts();
    }
}



