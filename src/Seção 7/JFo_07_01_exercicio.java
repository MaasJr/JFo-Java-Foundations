import java.util.Random;

class Card {
    private int cardNumber;
    private int creditBalance;
    private int ticketBalance;

    public Card(int cardNumber) {
        this.cardNumber = cardNumber;
        this.creditBalance = 0;
        this.ticketBalance = 0;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCreditBalance() {
        return creditBalance;
    }

    public int getTicketBalance() {
        return ticketBalance;
    }

    public void addCredits(int amount) {
        creditBalance += amount;
    }

    public void deductCredits(int amount) {
        creditBalance -= amount;
    }

    public void addTickets(int amount) {
        ticketBalance += amount;
    }

    public void deductTickets(int amount) {
        ticketBalance -= amount;
    }
}

class Game {
    private int requiredCredits;

    public Game(int requiredCredits) {
        this.requiredCredits = requiredCredits;
    }

    public int play(Card card) {
        if (card.getCreditBalance() < requiredCredits) {
            System.out.println("Card " + card.getCardNumber() + " does not have enough credits to play.");
            return 0;
        }

        card.deductCredits(requiredCredits);
        Random random = new Random();
        int ticketCount = random.nextInt(10) + 1;
        card.addTickets(ticketCount);

        System.out.println("Card " + card.getCardNumber() + ": Won " + ticketCount + " tickets. Credit balance: " + card.getCreditBalance() + ", Ticket balance: " + card.getTicketBalance());

        return ticketCount;
    }
}

class PrizeCategory {
    private String name;
    private int requiredTickets;
    private int itemCount;

    public PrizeCategory(String name, int requiredTickets, int itemCount) {
        this.name = name;
        this.requiredTickets = requiredTickets;
        this.itemCount = itemCount;
    }

    public String getName() {
        return name;
    }

    public int getRequiredTickets() {
        return requiredTickets;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void decrementItemCount() {
        itemCount--;
    }
}

class Terminal {
    private Card card;
    private PrizeCategory[] prizeCategories;

    public Terminal(PrizeCategory[] prizeCategories) {
        this.prizeCategories = prizeCategories;
    }

    public void insertCard(Card card) {
        this.card = card;
    }

    public void loadCredits(int amount) {
        card.addCredits(amount);
        System.out.println("Card " + card.getCardNumber() + ": Loaded credits. Credit balance: " + card.getCreditBalance());
    }

    public void transferCredits(int amount, Card destinationCard) {
        if (card.getCreditBalance() < amount) {
            System.out.println("Card " + card.getCardNumber() + " does not have enough credits for transfer.");
            return;
        }

        card.deductCredits(amount);
        destinationCard.addCredits(amount);

        System.out.println("Transferred " + amount + " credits from Card " + card.getCardNumber() + " to Card " + destinationCard.getCardNumber() + ".");
        System.out.println("Credit balance of Card " + card.getCardNumber() + ": " + card.getCreditBalance());
        System.out.println("Credit balance of Card " + destinationCard.getCardNumber() + ": " + destinationCard.getCreditBalance());
    }

    public void redeemPrize(PrizeCategory prizeCategory) {
        if (card.getTicketBalance() < prizeCategory.getRequiredTickets()) {
            System.out.println("Card " + card.getCardNumber() + " does not have enough tickets to redeem prize from category " + prizeCategory.getName() + ".");
            return;
        }

        if (prizeCategory.getItemCount() <= 0) {
            System.out.println("Terminal has no more prizes available for category " + prizeCategory.getName() + ".");
            return;
        }

        card.deductTickets(prizeCategory.getRequiredTickets());
        prizeCategory.decrementItemCount();

        System.out.println("Card " + card.getCardNumber() + ": Redeemed prize from category " + prizeCategory.getName() + ".");
        System.out.println("Ticket balance of Card " + card.getCardNumber() + ": " + card.getTicketBalance());
        System.out.println("Remaining quantity of prizes in category " + prizeCategory.getName() + ": " + prizeCategory.getItemCount());
    }
}

public class JFo_07_01_exercicio {
    public static void main(String[] args) {

        Card card1 = new Card(1);
        Card card2 = new Card(2);

        Game game = new Game(2);

        PrizeCategory[] prizeCategories = {
            new PrizeCategory("Category 1", 5, 3),
            new PrizeCategory("Category 2", 10, 5),
            new PrizeCategory("Category 3", 15, 2)
        };

        Terminal terminal = new Terminal(prizeCategories);

        terminal.insertCard(card1);
        terminal.loadCredits(10);
        terminal.insertCard(card2);
        terminal.loadCredits(5);

        int tickets1 = game.play(card1);
        int tickets2 = game.play(card2);


        terminal.insertCard(card1);
        terminal.transferCredits(card1.getCreditBalance(), card2);
        terminal.transferCredits(card1.getTicketBalance(), card2);

        terminal.insertCard(card2);
        terminal.redeemPrize(prizeCategories[0]);
        terminal.redeemPrize(prizeCategories[1]);
        terminal.redeemPrize(prizeCategories[2]);

        terminal.insertCard(card1);
        game.play(card1);
        terminal.redeemPrize(prizeCategories[0]);
    }
}
