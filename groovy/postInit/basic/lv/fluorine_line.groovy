import mods.gregtech.chemical_reactor;
import mods.gregtech.centrifuge;
centrifuge.removeByInput(80, [item('minecraft:glowstone_dust') * 2], null)
chemical_reactor.recipeBuilder()
    .inputs(ore('dustGlowstone')*3)
    .fluidInputs(fluid('sulfuric_acid')*1000, fluid('water')*2000)
    .outputs(ore('dustGypsum')[0]*8)
    .fluidOutputs(fluid('hydrofluoric_acid')*2000)
    .EUt(30)
    .duration(300)
    .buildAndRegister();
chemical_reactor.recipeBuilder()
    .inputs(ore('dustSodiumAluminate')*12)
    .fluidInputs(fluid('hydrofluoric_acid')*6000)
    .outputs(ore('dustCryolite')[0]*10,ore('dustAlumina')[0]*5)
    .fluidOutputs(fluid('water')*3000)
    .EUt(30)
    .duration(1200)
    .buildAndRegister();