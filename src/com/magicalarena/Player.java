package com.magicalarena;

public class Player {
	private String name;
	private int health;
	int strength;
	int attack;

	public Player(String name, int health, int strength, int attack) {
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.attack = attack;
	}

	public boolean isAlive() {
		return health > 0;
	}

	public int attackRoll() {
		return (int) (Math.random() * 6) + 1;
	}

	public int defendRoll() {
		return (int) (Math.random() * 6) + 1;
	}

	public void takeDamage(int damage) {
		this.health -= damage;
		if (this.health < 0) {
			this.health = 0;
		}
	}

	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s: Health = %d, Strength = %d, Attack = %d", name, health, strength, attack);
	}
}
