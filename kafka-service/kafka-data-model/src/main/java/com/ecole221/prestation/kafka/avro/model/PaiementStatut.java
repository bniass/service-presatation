/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.ecole221.prestation.kafka.avro.model;
@org.apache.avro.specific.AvroGenerated
public enum PaiementStatut implements org.apache.avro.generic.GenericEnumSymbol<PaiementStatut> {
  EN_ATTENTE, TERMINE, ANNULE, ECHEC  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"PaiementStatut\",\"namespace\":\"com.ecole221.prestation.kafka.avro.model\",\"symbols\":[\"EN_ATTENTE\",\"TERMINE\",\"ANNULE\",\"ECHEC\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}