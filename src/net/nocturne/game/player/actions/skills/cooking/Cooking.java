package net.nocturne.game.player.actions.skills.cooking;

import net.nocturne.Settings;
import net.nocturne.game.Animation;
import net.nocturne.game.World;
import net.nocturne.game.WorldObject;
import net.nocturne.game.item.Item;
import net.nocturne.game.item.ItemIdentifiers;
import net.nocturne.game.player.CompletionistCapeManager.Requirement;
import net.nocturne.game.player.GamePointManager.GPR;
import net.nocturne.game.player.Player;
import net.nocturne.game.player.Skills;
import net.nocturne.game.player.actions.Action;
import net.nocturne.game.player.content.SkillsDialogue;
import net.nocturne.utils.Color;
import net.nocturne.utils.Utils;

public class Cooking extends Action {

	public enum Cookables {

		SINEW(new Item(2132, 1), 1, 1, 3, new Item(2146, 1), new Item(9436, 1),
				false, false),

		RAW_MEAT(new Item(2132, 1), 1, 200, 30, new Item(2146, 1), new Item(
				2142, 1), false, false),

		RAW_CHICKEN(new Item(2138, 1), 1, 200, 30, new Item(2144, 1), new Item(
				4291, 1), false, false),

		RAW_UGTHANKI_MEAT(new Item(1859, 1), 1, 200, 30, new Item(2146, 1),
				new Item(1861, 1), false, false),

		RAW_RABBIT(new Item(3226, 1), 1, 200, 30, new Item(7222, 1), new Item(
				3228, 1), false, true),

		RAW_BIRD_MEAT(new Item(9978, 1), 11, 200, 62, new Item(9982, 1),
				new Item(9980, 1), true, false),

		RAW_CRAB_MEAT(new Item(7518, 1), 21, 200, 100, new Item(7520, 1),
				new Item(7521, 1), false, false),

		RAW_BEAST_MEAT(new Item(9986, 1), 21, 200, 82, new Item(9990, 1),
				new Item(9988, 1), true, false),

		RAW_CHOMPY(new Item(2876, 1), 30, 200, 140, new Item(2880, 1),
				new Item(2878, 1), false, true),

		RAW_JUBBLY(new Item(7566, 1), 41, 200, 160, new Item(7570, 1),
				new Item(7568, 1), true, false),

		RAW_CRAYFISH(new Item(13435, 1), 1, 32, 30, new Item(13437, 1),
				new Item(13433, 1), false, false),

		RAW_SHRIMP(new Item(317, 1), 1, 34, 30, new Item(7954, 1), new Item(
				315, 1), false, false),

		RAW_KARAMBWANJI(new Item(3150, 1), 1, 35, 10, new Item(3148, 1),
				new Item(3151, 1), false, false),
	

		RAW_SARDINE(new Item(327, 1), 1, 38, 40, new Item(323, 1), new Item(
				325, 1), false, false),

		RAW_ANCHOVIES(new Item(321, 1), 1, 34, 30, new Item(323, 1), new Item(
				319, 1), false, false),

		POISON_KARAMBWAN(new Item(3142, 1), 1, 20, 80, new Item(3148, 1),
				new Item(3151, 1), false, false),

		RAW_HERRING(new Item(345, 1), 5, 37, 50, new Item(357, 1), new Item(
				347, 1), false, false),

		RAW_MACKEREL(new Item(353, 1), 10, 45, 60, new Item(357, 1), new Item(
				355, 1), false, false),

		RAW_TROUT(new Item(335, 1), 15, 50, 70, new Item(343, 1), new Item(333,
				1), false, false),

		RAW_COD(new Item(341, 1), 18, 39, 75, new Item(343, 1),
				new Item(339, 1), false, false),

		RAW_PIKE(new Item(349, 1), 20, 52, 80, new Item(349, 1), new Item(351,
				1), false, false),

		RAW_SALMON(new Item(331, 1), 25, 58, 90, new Item(343, 1), new Item(
				329, 1), false, false),

		RAW_SLIMY_EEL(new Item(3379, 1), 28, 58, 95, new Item(3383, 1),
				new Item(3381, 1), false, false),

		RAW_TUNA(new Item(359, 1), 30, 63, 100, new Item(367, 1), new Item(361,
				1), false, false),

		RAW_RAINBOW_FISH(new Item(10138, 1), 35, 60, 110, new Item(10140, 1),
				new Item(10136, 1), false, false),

		RAW_CAVE_EEL(new Item(5001, 1), 38, 40, 115, new Item(5006, 1),
				new Item(5003, 1), false, false),

		RAW_LOBSTER(new Item(377, 1), 40, 66, 120, new Item(381, 1), new Item(
				379, 1), false, false),

		RAW_BASS(new Item(363, 1), 43, 80, 130, new Item(367, 1), new Item(365,
				1), false, false),

		RAW_SWORDFISH(new Item(371, 1), 45, 86, 140, new Item(375, 1),
				new Item(373, 1), false, false),

		RAW_LAVA_EEL(new Item(2148, 1), 53, 53, 30, new Item(-1, 1), new Item(
				2149, 1), false, false),

		RAW_MONKFISH(new Item(7944, 1), 62, 90, 150, new Item(7948, 1),
				new Item(7946, 1), false, false),

		RAW_SHARK(new Item(383, 1), 80, 100, 210, new Item(387, 1), new Item(
				385, 1), false, false),

		RAW_SEA_TURTLE(new Item(395, 1), 82, 200, 212, new Item(399, 1),
				new Item(397, 1), false, false),

		RAW_CAVEFISH(new Item(15264, 1), 88, 100, 214, new Item(15268, 1),
				new Item(15266, 1), false, false),

		RAW_MANTA_RAY(new Item(389, 1), 91, 200, 216, new Item(393, 1),
				new Item(391, 1), false, false),

		RAW_ROCKTAIL(new Item(15270, 1), 92, 100, 225, new Item(15274, 1),
				new Item(15272, 1), false, false),

		RAW_REDBERRY_PIE(new Item(2321, 1), 10, 200, 78, new Item(2329, 1),
				new Item(2325, 1), false, false),

		RAW_MEAT_PIE(new Item(2319, 1), 20, 200, 110, new Item(2329, 1),
				new Item(2327, 1), false, false),

		RAW_MUD_PIE(new Item(7168, 1), 29, 200, 128, new Item(2329, 1),
				new Item(7170, 1), false, false),

		RAW_APPLE_PIE(new Item(2317, 1), 30, 200, 130, new Item(2329, 1),
				new Item(2323, 1), false, false),

		RAW_GARDEN_PIE(new Item(7176, 1), 34, 200, 138, new Item(2329, 1),
				new Item(7178, 1), false, false),

		RAW_FISH_PIE(new Item(7186, 1), 47, 200, 164, new Item(2329, 1),
				new Item(7188, 1), false, false),

		RAW_ADMIRAL_PIE(new Item(7196, 1), 70, 200, 210, new Item(2329, 1),
				new Item(7198, 1), false, false),

		RAW_WILD_PIE(new Item(7206, 1), 85, 200, 240, new Item(2329, 1),
				new Item(7208, 1), false, false),

		RAW_SUMMER_PIE(new Item(7216, 1), 95, 200, 260, new Item(2329, 1),
				new Item(7218, 1), false, false),

		RAW_FISHCAKE(new Item(7529, 1), 31, 200, 100, new Item(7531, 1),
				new Item(7530, 1), false, false),

		RAW_POTATO(new Item(1942, 1), 7, 25, 15, new Item(6699, 1), new Item(
				6701, 1), false, false),

		RAW_PIZZA(new Item(2287), 35, 80, 143, new Item(2305), new Item(2289),
				false, false),

		SCRAMBLED_EGG(new Item(7076), 13, 40, 50, new Item(7090),
				new Item(7078), false, false),

		FRIED_ONIONS(new Item(1871), 42, 70, 60, new Item(7092),
				new Item(7084), false, false),

		FRIED_MUSHROOM(new Item(7080), 46, 83, 60, new Item(7094), new Item(
				7082), false, false),

		BREAD(new Item(2307), 1, 35, 40, new Item(2311), new Item(2309), false,
				false),

		PITTA_BREAD(new Item(1863), 58, 80, 40, new Item(1867), new Item(1865),
				false, false),

		CAKE(new Item(1889), 40, 65, 120, new Item(1903), new Item(1891),
				false, false),

		SWEETCORN(new Item(5986), 28, 50, 114, new Item(5990), new Item(5988),
				false, false),
		
		RAW_TARPON(new Item(ItemIdentifiers.RAW_TARPON, 9), 91, 99, 120, new Item(ItemIdentifiers.BURNT_TARPON), new Item(ItemIdentifiers.FISH_OIL), false, false),
		
		RAW_SEERFISH(new Item(ItemIdentifiers.RAW_SEERFISH, 6), 91, 99, 120, new Item(ItemIdentifiers.BURNT_SEERFISH), new Item(ItemIdentifiers.FISH_OIL), false, false),
		
		RAW_SILLAGO(new Item(ItemIdentifiers.RAW_SILLAGO, 3), 91, 99, 120, new Item(ItemIdentifiers.BURNT_SILLAGO), new Item(ItemIdentifiers.FISH_OIL), false, false),
		
		ARC_GUMBO(new Item(ItemIdentifiers.UNCOOKED_ARC_GUMBO), 94, 99, 130, new Item(ItemIdentifiers.BURNT_ARC_GUMBO), new Item(ItemIdentifiers.ARC_GUMBO), false, false),

		HARDENED_STRAIT_ROOT(new Item(21349), 83, 1, 379, new Item(-1),
				new Item(21351), false, true),

		SODA_ASH_1(new Item(401), 1, 0, 3, new Item(1781), new Item(1781),
				false, false),

		SODA_ASH_2(new Item(7516), 1, 0, 3, new Item(1781), new Item(1781),
				false, false),

		SODA_ASH_3(new Item(10978), 1, 0, 3, new Item(1781), new Item(1781),
				false, false),

		CAVE_POTATO(new Item(17817), 1, 0, 9, new Item(-1), new Item(18093),
				false, false),

		HIEM_CRAB(new Item(17797), 1, 20, 22, new Item(18179), new Item(18159),
				false, false),

		RED_EYE(new Item(17799), 10, 30, 41, new Item(18181), new Item(18161),
				false, false),

		DUSK_EEL(new Item(17801), 20, 40, 61, new Item(18183), new Item(18163),
				false, false),

		GIANT_FLATFISH(new Item(17803), 30, 50, 82, new Item(18185), new Item(
				18165), false, false),

		SHORTFINNED_EEL(new Item(17805), 40, 60, 103, new Item(18187),
				new Item(18167), false, false),

		WEB_SNIPPER(new Item(17807), 50, 70, 124, new Item(18189), new Item(
				18169), false, false),

		BOULDABASS(new Item(17809), 60, 70, 146, new Item(18191), new Item(
				18171), false, false),

		SALVE_EEL(new Item(17811), 70, 70, 168, new Item(18193),
				new Item(18173), false, false),

		BLUE_CRAB(new Item(17813), 80, 70, 191, new Item(18195),
				new Item(18175), false, false),

		CAVE_MORAY(new Item(17815), 90, 70, 215, new Item(18197), new Item(
				18177), false, false),

		VILE_FISH(new Item(17374), 1, 0, 90, new Item(17375), new Item(17375),
				false, true);

		public static Cookables forId(int itemId) {
			for (Cookables cook : Cookables.values()) {
				if (itemId == cook.getRawItem().getId())
					return cook;
			}
			return null;
		}

		private Item raw;
		private int lvl;
		private int burningLvl;
		private int xp;
		private Item burnt;
		private Item total;
		private boolean spitRoast;
		private boolean fireOnly;

		Cookables(Item raw, int lvl, int burningLvl, int exp,
				Item burnt, Item total, boolean spitRoast, boolean fireOnly) {
			this.raw = raw;
			this.lvl = lvl;
			this.burningLvl = burningLvl;
			this.xp = exp;
			this.burnt = burnt;
			this.total = total;
			this.spitRoast = spitRoast;
			this.fireOnly = fireOnly;
		}

		public Item getRawItem() {
			return raw;
		}

		public int getLvl() {
			return lvl;
		}

		public Item getBurntId() {
			return burnt;
		}

		public Item getProduct() {
			return total;
		}

		public int getXp() {
			return xp;
		}

		public int getBurningLvl() {
			return burningLvl;
		}

		public Item getTotal() {
			return total;
		}

		public boolean isSpitRoast() {
			return spitRoast;
		}

		public boolean isFireOnly() {
			return fireOnly;
		}
	}

	private int amount;
	private Cookables cook;
	private Item item;
	private WorldObject object;
	private Animation FIRE_COOKING = new Animation(897),
			RANGE_COOKING = new Animation(897);
	private int xpMultiplier = 1;

	public Cooking(WorldObject object, Item item, int amount, Cookables cook) {
		this.amount = amount;
		this.item = item;
		this.object = object;
		this.cook = cook;
	}

	@Override
	public boolean start(Player player) {
		if (cook == null)
			cook = Cookables.forId(item.getId());
		if (cook == null) {
			return false;
		}
		if (cook.isFireOnly() && !object.getDefinitions().name.contains("Fire")) {
			player.getDialogueManager().startDialogue("SimpleMessage",
					"You may only cook this on a fire.");
		} else if (cook.isSpitRoast() && object.getId() != 11363) {
			player.getDialogueManager().startDialogue("SimpleMessage",
					"You may only cook this on an iron spit.");
			return false;
		}
		if (!process(player))
			return false;
		player.getPackets().sendGameMessage(
				"You attempt to cook the "
						+ cook.getProduct().getDefinitions().getName()
								.toLowerCase() + ".", true);
		player.faceObject(object);
		return true;
	}

	private boolean isBurned(Cookables cook, Player player) {
		int level = player.getSkills().getLevel(Skills.COOKING);
		if (player.getEquipment().getGlovesId() == 775)
			level += 6;
		if (player.getGamePointManager().hasGamePointsReward(GPR.MORE_SUCCESS))
			level += 5;
		int burnLevel = cook.getBurningLvl();
		if (burnLevel == 120) {
			burnLevel = 100 + cook.getLvl() / 10;
		}
		int levelsToStopBurn = burnLevel - level;
		if (levelsToStopBurn <= 0) {
			return false;
		}
		if (levelsToStopBurn > 20) {
			levelsToStopBurn = 20;
		}
		int levelsAhead = Utils.random(level - cook.getLvl());
		int levelsToBurn = 20 - levelsToStopBurn;
		levelsToBurn += levelsAhead;
		double baseChance = 0.2;
		double chanceOfCooking = baseChance + Math.log(levelsToBurn * 0.25 + 1);
		boolean cooked = Math.random() <= chanceOfCooking;
		return !cooked;
	}

	public static Cookables isCookingSkill(Item item) {
		return Cookables.forId(item.getId());
	}

	public static Cookables getCook(Player player) {
		for (Cookables c : Cookables.values()) {
			if (player.getInventory().containsOneItem(c.raw.getId()))
				return c;
		}
		return Cookables.RAW_CHICKEN;
	}

	public static Cookables getCookForProduce(int id) {
		for (Cookables c : Cookables.values()) {
			if (c.getProduct().getId() == id)
				return c;
		}
		return null;
	}

	@Override
	public boolean process(Player player) {
		if (!World.containsObjectWithId(object, object.getId())){
			player.getInterfaceManager().removeInterface(1251);
			return false;
	}
		if (!player.getInventory().containsItem(item.getId(), item.getAmount())){
			player.getInterfaceManager().removeInterface(1251);
			return false;
}
		if (!player.getInventory().containsItem(cook.getRawItem().getId(),
				cook.getRawItem().getAmount())){
			player.getInterfaceManager().removeInterface(1251);
			return false;
			}
		if (!player.getSkills().hasLevel(
				cook.getRawItem().getId() == Cookables.HARDENED_STRAIT_ROOT
						.getRawItem().getId() ? Skills.FIREMAKING
						: Skills.COOKING, cook.getLvl())){
			player.getInterfaceManager().removeInterface(1251);
			return false;
			}
		return true;
	}

	@Override
	public int processWithDelay(Player player) {
		amount--;
		int xp = cook.getXp();
		int maxQuantity = player.getVarsManager().getBitValue(1002);
		maxQuantity = (int) player.getTemporaryAttributtes().get("quantity");
		player.setNextAnimation(object.getDefinitions().name.contains("fire") ? FIRE_COOKING
				: RANGE_COOKING);
		if (player.getSkills( ).getLevel( Skills.COOKING ) < cook
				.getBurningLvl( ) && isBurned( cook, player )) {
			player.getInventory().deleteItem(item.getId(), item.getAmount());
			player.getInventory().addItem(cook.getBurntId().getId(),
					cook.getBurntId().getAmount());
			player.getPackets().sendGameMessage(
					"Oops! You accidentally burnt the "
							+ cook.getProduct().getDefinitions().getName()
									.toLowerCase() + ".", true);
		} else {
			player.getInventory().deleteItem(item.getId(), item.getAmount());
			player.getInventory().addItem(cook.getProduct().getId(),
					cook.getProduct().getAmount());
			if (player.getClanManager() != null && player.getClanManager().getClan() != null)
				player.getClanManager().getClan().increaseGatheredResources(cook.getProduct().getAmount());
			player.getSkills().addXp(
					cook.getRawItem().getId() == Cookables.HARDENED_STRAIT_ROOT
							.getRawItem().getId() ? Skills.FIREMAKING
							: Skills.COOKING, cook.getXp());
			if (cook.getBurntId().getId() == 1781) {
				player.getPackets().sendGameMessage(
						"You burn the " + item.getName() + " to soda ash.");
			} else {
				player.getPackets().sendGameMessage(
						"You successfully cook the "
								+ cook.getProduct().getDefinitions().getName()
										.toLowerCase() + ".", true);
				player.getSkillTasks().handleTask(cook, 1);
				if (player.getDailyTask() != null)
					player.getDailyTask().incrementTask(player, 3,
							item.getId(), Skills.COOKING);
				player.getCompCapeManager().increaseRequirement(Requirement.COOK_FISH, 1);
				player.getGamePointManager().increaseGamePoints((cook.getXp() / 10));
				handlePets(player);
			}
		}
		if (cook.getBurntId() == Cookables.CAKE.getBurntId())
			player.getInventory().addItemDrop(1887, 1);
		else if (cook.getRawItem().getId() == Cookables.HARDENED_STRAIT_ROOT
				.getRawItem().getId())
			player.setFavorPoints(2 + player.getFavorPoints());
		if (maxQuantity > 1){
		SkillsDialogue.sendProgressBar(player, cook.getProduct().getId(), maxQuantity, (int) xp);
		player.getPackets().sendCSVarInteger(2229, maxQuantity - xpMultiplier);
		xpMultiplier++;
		}
		if (amount > 0) {
			player.getPackets().sendGameMessage(
					"You attempt to cook the "
							+ cook.getProduct().getDefinitions().getName()
									.toLowerCase() + ".", true);
			return 3;
		}
		return -1;
	}
	
	private void handlePets(Player player) {
		if (Utils.random(1000) == 1) {
			player.getBank().addItem(ItemIdentifiers.COMMANDER_PORKINS, 1, true);
			player.getPackets().sendGameMessage(Color.WHITE, "You have received commander porkins the pet! It has been transferred to your bank!" );
		}
		if (Utils.random(500) == 1) {
			player.getBank().addItem(ItemIdentifiers.PIGGLES, 1, true);
			player.getPackets().sendGameMessage(Color.WHITE, "You have received piggles the pet! It has been transferred to your bank!" );
		}
	}

	@Override
	public void stop(final Player player) {
		setActionDelay(player, 3);
	}
}