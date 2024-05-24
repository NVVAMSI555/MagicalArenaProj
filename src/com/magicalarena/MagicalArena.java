package com.magicalarena;
public class MagicalArena {

    public static void conductMatch(Player player1, Player player2) {
        Player[] players = new Player[]{player1, player2};
        // Sort players by health; player with lower health attacks first
        if (player2.getHealth() < player1.getHealth()) {
            players[0] = player2;
            players[1] = player1;
        }

        while (player1.isAlive() && player2.isAlive()) {
            Player attacker = players[0];
            Player defender = players[1];

            int attackRoll = attacker.attackRoll();
            int defendRoll = defender.defendRoll();

            int attackDamage = attacker.attack * attackRoll;
            int defendStrength = defender.strength * defendRoll;

            int damageDealt = Math.max(0, attackDamage - defendStrength);
            defender.takeDamage(damageDealt);

            System.out.println(attacker.getName() + " attacks " + defender.getName() + "!");
            System.out.println(attacker.getName() + " rolls " + attackRoll + ", " + defender.getName() + " rolls " + defendRoll);
            System.out.println("Attack damage: " + attackDamage + ", Defend strength: " + defendStrength);
            System.out.println("Damage dealt to " + defender.getName() + ": " + damageDealt);
            System.out.println(defender.getName() + " health: " + defender.getHealth() + "\n");

            // Switch roles for the next round
            Player temp = players[0];
            players[0] = players[1];
            players[1] = temp;
        }

        Player winner = player1.isAlive() ? player1 : player2;
        System.out.println(winner.getName() + " wins the match!");
    }

    public static void main(String[] args) {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        System.out.println("Starting the match between Player A and Player B");
        System.out.println(playerA);
        System.out.println(playerB);
        System.out.println("\nLet the match begin!\n");

        conductMatch(playerA, playerB);
    }
}
