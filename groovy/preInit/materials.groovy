import static gregtech.api.unification.ore.OrePrefix.*
import gregtech.api.unification.material.properties.PropertyKey
import gregtech.api.unification.material.info.MaterialFlag
import gregtech.api.fluids.FluidBuilder
import gregtech.api.fluids.store.FluidStorageKey
def onMaterialEvent={
    def ancient_debris=materialBuilder(32000,"ancient_debris")
        .color(0x6e505a)
        .ingot()
        .flags("no_working")
        .build()
    ancient_debris.setFormula('Nr')
    ingot.setIgnored(ancient_debris)

    def netherite=materialBuilder(32001,"netherite")
        .color(0x504650)
        .ingot()
        .flags("disable_decomposition","generate_plate","generate_double_plate")
        .components(ancient_debris*4,material('gold')*4)
        .cableProperties(4096,2,30,false)
        .build()
    ingot.setIgnored(netherite)
    def manyullyn=materialBuilder(32002,"manyullyn")
        .fluid()
        .color(0x9261cc)
        .ingot()
        .blastTemp(1473,"LOW",480)
        .components(material("cobalt")*3,ancient_debris*1)
        .iconSet('metallic')
        .build()
    def amber=materialBuilder(32003,"amber")
        .color(0xffd0000)
        .gem(3)
        .ore()
        .components(material("carbon")*10,material("hydrogen")*16,material("oxygen")*1)
        .iconSet('diamond')
        .flags('high_sifter_output','disable_decomposition')
        .build()
    def tanzanite=materialBuilder(32004,'tanzanite')
        .color(0x6200ff)
        .gem(3)
        .ore()
        .components(material('sapphire')*3,material('silicon_dioxide')*2,material('calcium')*4,material('oxygen')*4,material('water')*1)
        .flags('high_sifter_output','generate_lens')
        .build()
    def galaxy=materialBuilder(32005,'galaxy')
        .color(0x5c01bc)
        .gem(5)
        .iconSet('diamond')
        .fluid()
        .build()
    def terrestrial_artifact=materialBuilder(32006,'terrestrial_artifact')
        .color(0x7cfc00)
        .gem(5)
        .iconSet('diamond')
        .fluid()
        .build()
    def cracker_graham_ungraded=materialBuilder(32007,'cracker_graham_ungraded')
        .color(0xbb9749)
        .dust()
        .flags('generate_plate')
        .build()
    plate.setIgnored(cracker_graham_ungraded)
    def matter_graham_hot=materialBuilder(32008,'matter_graham_hot')
        .color(0xc7b07e)
        .dust()
        .ore()
        .flags('generate_plate','generate_dense','disable_ore_block')
        .build()
    crushed.setIgnored(matter_graham_hot)
    plate.setIgnored(matter_graham_hot)
    plateDense.setIgnored(matter_graham_hot)
    def matter_graham=materialBuilder(32009,'matter_graham')
        .color(0x8a7036)
        .dust()
        .ore()
        .flags('disable_ore_block')
        .oreSmeltInto(matter_graham_hot)
        .build()
    crushed.setIgnored(matter_graham)
    matter_graham_hot.getProperty(PropertyKey.ORE).setOreByProducts(cracker_graham_ungraded,matter_graham)
    def aquamarine=materialBuilder(32010,"aquamarine")
        .color(0x006fc1)
        .gem()
        .ore()
        .components(material('emerald')*1)
        .iconSet('emerald')
        .build()
    gem.setIgnored(aquamarine);
    def polymetal=materialBuilder(32011,"polymetal")
        .color(0x303030)
        .ingot()
        .ore()
        .build()
    ingot.setIgnored(polymetal)
    polymetal.getProperty(PropertyKey.ORE).setOreByProducts(material('manganese'))
    def grudge=materialBuilder(32012,"grudge")
        .color(0x8c2c2c)
        .build()
    def abyssium=materialBuilder(32013,"abyssium")
        .color(0xc2173e)
        .ingot(3)
        .components(material('iron')*1,grudge*1)
        .build()
    ingot.setIgnored(abyssium)
    def pulsating=materialBuilder(32014,"pulsating_iron")
        .ingot()
        .liquid()
        .color(0x80F69B)
        .iconSet('metallic')
        .components(material('iron')*1,material('ender_pearl')*1)
        .flags('generate_plate', 'generate_rod', 'generate_foil', 'generate_fine_wire', 'generate_frame','generate_gear', 'generate_small_gear', 'generate_bolt_screw')
        .cableProperties(8, 1, 0, true)
        .build();
    def pulsating_crystal=materialBuilder(32015,"pulsating_crystal")
        .gem()
        .color(0xb3e8ff)
        .iconSet('diamond')
        .components(pulsating*1,material('diamond')*1)
        .flags('disable_decomposition','generate_plate','generate_rod','generate_lens')
        .build()
    def pink_slime=materialBuilder(32016,"pink_slime")
        .ingot()
        .fluid()
        .color(0xe7cae2)
        .iconSet('metallic')
        .components(material('iron')*1,material('rubber')*8)
        .flags('disable_decomposition','generate_plate','generate_rod','generate_gear')
        .build();
    def crystalline_pink_slime=materialBuilder(32017,"crystalline_pink_slime")
        .ingot()
        .fluid()
        .color(0xF5B8EB)
        .iconSet('bright')
        .components(pink_slime*1,pulsating_crystal*1)
        .flags('disable_decomposition','generate_plate', 'generate_rod', 'generate_foil', 'generate_fine_wire', 'generate_frame','generate_gear', 'generate_small_gear', 'generate_bolt_screw')
        .blastTemp(4500,'HIGH',7500,1000,480,400)
        .build();
    def prismarine=materialBuilder(32018,"prismarine")
        .gem()
        .color(0x92CDDC)
        .iconSet('shiny')
        .flags('no_smashing','generate_plate','exclude_block_crafting_by_hand_recipes')
        .build()
    gem.setIgnored(prismarine)
    def gallite=materialBuilder(32019,"gallite")
        .dust()
        .color(0xeeeeee)
        .components(material('copper')*1,material('gallium')*1,material('sulfur')*2)
        .build()
    def metallic_platinum=materialBuilder(32020,"metallic_platinum")
        .dust()
        .ore()
        .color(0xFFFFC8)
        .iconSet('metallic')
        .build()
    metallic_platinum.setFormula('??PtPdIrOsRhRu??')
    def metallic_palladium=materialBuilder(32021,"metallic_palladium")
        .dust()
        .ore()
        .color(0x808080)
        .iconSet('metallic')
        .build()
    metallic_palladium.setFormula('??Pd??')
    
    def alumina=materialBuilder(32022,"alumina")
        .dust()
        .color(0xc8c8c8)
        .components(material('aluminium')*2,material('oxygen')*3)
        .flags('disable_decomposition')
        .build()
    alumina.setFormula('γ-Al2O3',true)
    dust.setIgnored(alumina)
    def sodium_aluminate=materialBuilder(32023,"sodium_aluminate")
        .dust()
        .color(0xf0f0f0)
        .components(material('sodium')*1,material('aluminium')*1,material('oxygen')*2)
        .flags('disable_decomposition')
        .build()
    def sodium_aluminate_solution=materialBuilder(32024,"sodium_aluminate_solution")
        .fluid()
        .color(0xeeeeff)
        .components(sodium_aluminate*1,material('water')*2)
        .flags('disable_decomposition')
        .build();
    sodium_aluminate_solution.setFormula('Na[Al(OH)4]',true)
    def aluminium_hydroxide=materialBuilder(32025,"aluminium_hydroxide")
        .dust()
        .color(0xf0f0f0)
        .components(alumina*1,material('water')*3)
        .flags('disable_decomposition')
        .build()
    aluminium_hydroxide.setFormula('Al(OH)3',true)
    def raw_graphite=materialBuilder(32026,'raw_graphite')
        .polymer()
        .color(0xc8c8c8)
        .iconSet('dull')
        .components(material('graphite')*1,material('rubber')*1)
        .flags('disable_decomposition','exclude_block_crafting_recipes','no_smelting','generate_plate','generate_foil','generate_rod','generate_long_rod')
        .build()
    //ExU2
    def enchanted_metal=materialBuilder(32027,'enchanted_metal')
        .ingot()
        .color(0xBFF260)
        .iconSet('metallic')
        .components(material('gold')*1,material('lapis')*1)
        .blastTemp(4800,'HIGHER',30720)//IV
        .flags('disable_decomposition','generate_plate')
        .build()
    ingot.setIgnored(enchanted_metal)
    def evil_metal=materialBuilder(32028,'evil_metal')
        .ingot()
        .color(0xFDFFA8)
        .iconSet('metallic')
        .components(material('iron')*8,material('europium')*1,material('nether_star')*1)
        .blastTemp(5000,'HIGHER',30720)
        .flags('disable_decomposition','generate_plate')
        .build()
    ingot.setIgnored(evil_metal)
    def dark_steel=materialBuilder(32029,'dark_steel')
        .ingot()
        .color(0x504650)
        .iconSet("metallic")
        .components(material('obsidian')*1,material('steel')*1)
        .flags('generate_plate',
                'generate_rod',
                "generate_gear",
                "generate_frame",
                "generate_small_gear",
                "generate_long_rod",
                "generate_spring",
                "generate_spring_small")
    .build();
    def end_steel=materialBuilder(32030,'end_steel')
        .ingot()
        .color(0xDFD9A5)
        .iconSet("metallic")
        .components(dark_steel*1,material('endstone')*1)
        .flags("generate_plate",
            "generate_rod",
            "generate_bolt_screw")
        .build();
    def chorus_fruit=materialBuilder(32031,'chorus_fruit')
        .dust()
        .color(0x886288)
        .iconSet('dull')
        .build()
    def melodic_alloy=materialBuilder(32032, 'melodic_alloy')
        .ingot()
        .color(0x886288)
        .iconSet('shiny')
        .components(end_steel*1,chorus_fruit*1)
        .flags('generate_plate','generate_rod','generate_gear')
        .build()
    def lapotron_precharged=materialBuilder(32033,'lapotron_precharged')
        .gem()
        .color(0x193bff)
        .flags('no_unification','disable_decomposition','explosive')
        .iconSet('magnetic')
        .components(material('lapotron')*1)
        .build()
    gemChipped.setIgnored(lapotron_precharged)
    def cryolite=materialBuilder(32034,'cryolite')
        .gem()
        .color(0xcdcdff)
        .liquid(new FluidBuilder().temperature(1220))
        .iconSet('diamond')
        .flags('disable_decomposition','crystallizable')
        .components(material('sodium')*3,material('aluminium')*1,material('fluorine')*6)
        .build()    
}
mods.gregtech.materialEvent(onMaterialEvent);