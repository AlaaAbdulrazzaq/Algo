
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB1;
/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    public String name;
    public String number;
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DirectoryEntry other = (DirectoryEntry) obj;
        return name.equals(other.name);
    }
}
