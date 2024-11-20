import gregtech.api.GregTechAPI;
event_manager.listen { GregTechAPI.RegisterEvent event ->
    def typeName=event.getGenericType().getTypeName()
    switch(typeName) {
        case 'gregtech.api.unification.stack.ItemMaterialInfo':
        {
            ore('circuitMv').add(item('gregtech_dingjen:micro_assembly'))
            ore('circuitHv').add(item('gregtech_dingjen:micro_computer'))
            ore('circuitEv').add(item('gregtech_dingjen:computer'))
        }
        default:
        {
            println(typeName)
            break
        }
    }
}