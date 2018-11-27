/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Image;

/**
 *
 * @author Marcelo
 */
public interface Parente {
    public Image getIcone();
    public void setEstadoAtivacao(boolean enable);
    public void setParente(Parente p);
}
