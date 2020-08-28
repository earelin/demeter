package org.earelin.demeter.domain.events;


import org.earelin.demeter.domain.areas.CultivatedArea;
import org.earelin.demeter.domain.areas.Subarea;

public class Sow extends Event {
  private int seeds;
  private CultivatedArea cultivatedArea;
  private Subarea position;
}
