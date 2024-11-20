import com.cleanroommc.groovyscript.event.LootTablesLoadedEvent
import net.minecraft.item.ItemStack

def add_entry( loot,table,pool,item,minRoll,maxRoll,minBonusRolls,maxBonusRolls,weight) {

    loot.getTable(table).addPool(
        loot.poolBuilder()
            .name(pool)
            .entry(loot.entryBuilder()
                .item(item)
                .function{stack, random, context ->
                stack.setCount(item.getCount())
                return stack
                }
                .weight(weight)
                .quality(1)
                .build()
                )
            .rollsRange(minRoll,maxRoll)
            .bonusRollsRange(minBonusRolls,maxBonusRolls)
            .build()
    )
}
event_manager.listen { LootTablesLoadedEvent event ->
    def loot=event.loot
    add_entry(loot,"twilightforest:entities/lich","bone",item('gregtech_dingjen:lich_bone')*3,1,1,0,0,100);
    add_entry(loot,"twilightforest:entities/snow_queen","snow_queen_blood",item('gregtech_dingjen:snow_queen_blood')*3,1,1,0,0,100);
    add_entry(loot,"twilightforest:entities/hydra","fiery_chop",item('gregtech_dingjen:fiery_chop')*3,1,1,0,0,100);
    add_entry(loot,"twilightforest:structures/stronghold_boss/stronghold_boss","tentacle",item('gregtech_dingjen:tentacle')*3,1,1,0,0,100);
    add_entry(loot,"twilightforest:structures/darktower_boss/darktower_boss","sad_slag",item('gregtech_dingjen:sad_slag')*3,1,1,0,0,100);
}