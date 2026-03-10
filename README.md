# Combat game
# Java OOP Combat Game

A terminal-based turn-based combat game set in the Vietnam War. Built as a school assignment to practice OOP in Java.

## Gameplay

You're a soldier whose helicopter was shot down. Enemies spawn one at a time and you take turns attacking. Kill enemies to loot their weapons, get healed every 3 kills via a number guessing minigame, and save your progress between sessions.


## Classes

| Class | Description |
|---|---|
| `GameCharacter` | Abstract base — handles attacking, healing, inventory |
| `Player` | Human player, dexterity 0.8 (high accuracy) |
| `Npc` | Random enemy type + weapon, dexterity 0.5 |
| `Weapon` | Name + damage value |
| `Save` | Serializes/deserializes player to `saves/Player.ser` |

## OOP Concepts

Inheritance, abstraction, encapsulation, polymorphism , and serialization for save/load.
