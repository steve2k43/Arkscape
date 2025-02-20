package net.nocturne.game.map.bossInstance.impl;

import net.nocturne.cache.loaders.NPCDefinitions;
import net.nocturne.game.World;
import net.nocturne.game.map.bossInstance.BossInstance;
import net.nocturne.game.map.bossInstance.InstanceSettings;
import net.nocturne.game.npc.combat.NPCCombatDefinitions;
import net.nocturne.game.player.Player;
import net.nocturne.utils.NPCCombatDefinitionsL;

public class ExiledKalphiteQueenInstance extends BossInstance {

	public ExiledKalphiteQueenInstance(Player owner, InstanceSettings settings) {
		super(owner, settings);
	}

	@Override
	public int[] getMapPos() {
		return new int[] { 368, 209 };
	}

	@Override
	public int[] getMapSize() {
		return new int[] { 1, 1 };
	}

	@Override
	public void loadMapInstance() {
		// guardian
		World.spawnNPC(16705, getTile(2960, 1707, 0), -1, true)
				.setBossInstance(this);
		World.spawnNPC(16705, getTile(2970, 1707, 0), -1, true)
				.setBossInstance(this);
		// marauder
		World.spawnNPC(16706, getTile(2970, 1697, 0), -1, true)
				.setBossInstance(this);
		World.spawnNPC(16706, getTile(2954, 1699, 0), -1, true)
				.setBossInstance(this);
		// queen
		World.spawnNPC(16707, getTile(2963, 1701, 0), -1, true)
				.setBossInstance(this);
	}

}
