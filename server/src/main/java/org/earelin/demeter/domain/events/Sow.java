package org.earelin.demeter.domain.events;


import org.earelin.demeter.domain.areas.CultivatedArea;
import org.earelin.demeter.domain.areas.Position;

public class Sow extends Event {
  private int seeds;
  private CultivatedArea cultivatedArea;
  private Position position;
}
