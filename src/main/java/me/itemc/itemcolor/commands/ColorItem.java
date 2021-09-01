package me.itemc.itemcolor.commands;

import me.itemc.itemcolor.ItemColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import sun.tools.jar.Main;

public class ColorItem implements CommandExecutor{
    private final ItemColor main;

    public ColorItem(ItemColor main){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("group.sponsor")){
                try{
                    ItemStack i = player.getItemInHand();
                    ItemMeta im = i.getItemMeta();
                    im.setDisplayName(args[0].replace("&", "§"));
                    i.setItemMeta(im);
                    player.sendMessage("ВЫ УСПЕШНО ПЕРЕИМЕНОВАЛИ ПРЕДМЕТ В " + args[0]);
                    return true;
                } catch (Exception e){
                    return false;
                }
            }
        }else{
            System.out.println("Команда не работает в консоли");
            return true;
        }
        return false;
    }
}