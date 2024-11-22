import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.properties.PropertyKey
import net.minecraftforge.fml.common.eventhandler.EventPriority;

def replaceOreByProducts()
{
    def replacements=[
        lithium:'spodumene',
        sodium:'sodalite',
        potassium:'potassium_feldspar',
        caesium:'pollucite',
        beryllium:'emerald',
        magnesium:'talc',
        calcium:'calcite',
        boron:'borax',
        aluminium:'bauxite',
        gallium:'sphalerite',
        tin:'cassiterite',
        platinum:'metallic_platinum',
        palladium:'metallic_palladium'
    ];
    def allMaterials=GregTechAPI.materialManager.getRegisteredMaterials()
    for (material1 in allMaterials) {
        if(material1.hasProperty(PropertyKey.ORE))
        {
            def oreProperty=material1.getProperty(PropertyKey.ORE)
            def byproducts=oreProperty.getOreByProducts().collect{
                for (entry in replacements) {
                    if(it == material(entry.key))
                    {
                        return material(entry.value)
                    }
                }
            }
            oreProperty.setOreByProducts(byproducts)
        }
    }
}
def disableDecomposition()
{
    def extraMaterials=['biotite','bastnasite','lepidolite','mica','enriched_uranium_hexafluoride','depleted_uranium_hexafluoride','fluoroantimonic_acid','bone']
    def allMaterials=GregTechAPI.materialManager.getRegisteredMaterials()
    for (material1 in allMaterials) {
        if(material1.hasProperty(PropertyKey.GEM))
        {
            material1.addFlags('disable_decomposition')
            continue;
        }
        for(entry in extraMaterials)
        {
            if(material1==material(entry))
            {
                material1.addFlags('disable_decomposition')
                break;
            }
        }
    }
}
mods.gregtech.lateMaterialEvent(EventPriority.NORMAL,{
    //modifyOreDictionary()
    material('magnesite').getProperty(PropertyKey.ORE).setDirectSmeltResult(material('magnesia'))
    material('graphene').addIngot()
    material('graphene').addFlags('no_smelting','generate_fine_wire')
    material('graphite').addIngot()
    //material('graphite').addBlastProperty(1750,'LOW',-1)
    material('graphite').addFlags('no_smelting','no_smashing','no_working','generate_plate','generate_foil','generate_rod','generate_long_rod','exclude_block_crafting_recipes')
    material('graphite').getProperty(PropertyKey.ORE).setDirectSmeltResult(material('carbon'))
    material('neodymium').addFlags('generate_long_rod')
    material('neodymium_magnetic').addFlags('generate_long_rod')
    material('tungsten_steel').addFlags('generate_round')
    material('samarium_iron_arsenic_oxide').addFlags('generate_fine_wire')
    material('bone').addIngot()
    material('bone')addFlags('no_smelting','no_smashing','no_working','generate_plate','generate_rod','exclude_block_crafting_recipes')

    material('brick').setFormula('Na4Li2Al4Si4O17',true)
    material('brick').addFlags('disable_decomposition');
    material('clay').setFormula('(Na4Li2Al4Si4O17)(H2O)12',true)
    material('glowstone').setFormula('CaF2',true);
    disableDecomposition()
    replaceOreByProducts()
})

