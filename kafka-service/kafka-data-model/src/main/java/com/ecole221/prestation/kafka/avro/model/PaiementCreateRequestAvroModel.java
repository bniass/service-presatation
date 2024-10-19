/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.ecole221.prestation.kafka.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class PaiementCreateRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8388434293873422845L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PaiementCreateRequestAvroModel\",\"namespace\":\"com.ecole221.prestation.kafka.avro.model\",\"fields\":[{\"name\":\"clientId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"demandeId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"montant\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"message\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"paiementStatut\",\"type\":{\"type\":\"enum\",\"name\":\"PaiementStatut\",\"symbols\":[\"EN_ATTENTE\",\"TERMINE\",\"ANNULE\",\"ECHEC\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<PaiementCreateRequestAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PaiementCreateRequestAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PaiementCreateRequestAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PaiementCreateRequestAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PaiementCreateRequestAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PaiementCreateRequestAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PaiementCreateRequestAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PaiementCreateRequestAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PaiementCreateRequestAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String clientId;
  private java.lang.String demandeId;
  private java.math.BigDecimal montant;
  private java.lang.String message;
  private com.ecole221.prestation.kafka.avro.model.PaiementStatut paiementStatut;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PaiementCreateRequestAvroModel() {}

  /**
   * All-args constructor.
   * @param clientId The new value for clientId
   * @param demandeId The new value for demandeId
   * @param montant The new value for montant
   * @param message The new value for message
   * @param paiementStatut The new value for paiementStatut
   */
  public PaiementCreateRequestAvroModel(java.lang.String clientId, java.lang.String demandeId, java.math.BigDecimal montant, java.lang.String message, com.ecole221.prestation.kafka.avro.model.PaiementStatut paiementStatut) {
    this.clientId = clientId;
    this.demandeId = demandeId;
    this.montant = montant;
    this.message = message;
    this.paiementStatut = paiementStatut;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return clientId;
    case 1: return demandeId;
    case 2: return montant;
    case 3: return message;
    case 4: return paiementStatut;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      new org.apache.avro.Conversions.DecimalConversion(),
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: clientId = value$ != null ? value$.toString() : null; break;
    case 1: demandeId = value$ != null ? value$.toString() : null; break;
    case 2: montant = (java.math.BigDecimal)value$; break;
    case 3: message = value$ != null ? value$.toString() : null; break;
    case 4: paiementStatut = (com.ecole221.prestation.kafka.avro.model.PaiementStatut)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'clientId' field.
   * @return The value of the 'clientId' field.
   */
  public java.lang.String getClientId() {
    return clientId;
  }


  /**
   * Sets the value of the 'clientId' field.
   * @param value the value to set.
   */
  public void setClientId(java.lang.String value) {
    this.clientId = value;
  }

  /**
   * Gets the value of the 'demandeId' field.
   * @return The value of the 'demandeId' field.
   */
  public java.lang.String getDemandeId() {
    return demandeId;
  }


  /**
   * Sets the value of the 'demandeId' field.
   * @param value the value to set.
   */
  public void setDemandeId(java.lang.String value) {
    this.demandeId = value;
  }

  /**
   * Gets the value of the 'montant' field.
   * @return The value of the 'montant' field.
   */
  public java.math.BigDecimal getMontant() {
    return montant;
  }


  /**
   * Sets the value of the 'montant' field.
   * @param value the value to set.
   */
  public void setMontant(java.math.BigDecimal value) {
    this.montant = value;
  }

  /**
   * Gets the value of the 'message' field.
   * @return The value of the 'message' field.
   */
  public java.lang.String getMessage() {
    return message;
  }


  /**
   * Sets the value of the 'message' field.
   * @param value the value to set.
   */
  public void setMessage(java.lang.String value) {
    this.message = value;
  }

  /**
   * Gets the value of the 'paiementStatut' field.
   * @return The value of the 'paiementStatut' field.
   */
  public com.ecole221.prestation.kafka.avro.model.PaiementStatut getPaiementStatut() {
    return paiementStatut;
  }


  /**
   * Sets the value of the 'paiementStatut' field.
   * @param value the value to set.
   */
  public void setPaiementStatut(com.ecole221.prestation.kafka.avro.model.PaiementStatut value) {
    this.paiementStatut = value;
  }

  /**
   * Creates a new PaiementCreateRequestAvroModel RecordBuilder.
   * @return A new PaiementCreateRequestAvroModel RecordBuilder
   */
  public static com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder newBuilder() {
    return new com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder();
  }

  /**
   * Creates a new PaiementCreateRequestAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PaiementCreateRequestAvroModel RecordBuilder
   */
  public static com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder newBuilder(com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder other) {
    if (other == null) {
      return new com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder();
    } else {
      return new com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PaiementCreateRequestAvroModel RecordBuilder by copying an existing PaiementCreateRequestAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new PaiementCreateRequestAvroModel RecordBuilder
   */
  public static com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder newBuilder(com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel other) {
    if (other == null) {
      return new com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder();
    } else {
      return new com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for PaiementCreateRequestAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PaiementCreateRequestAvroModel>
    implements org.apache.avro.data.RecordBuilder<PaiementCreateRequestAvroModel> {

    private java.lang.String clientId;
    private java.lang.String demandeId;
    private java.math.BigDecimal montant;
    private java.lang.String message;
    private com.ecole221.prestation.kafka.avro.model.PaiementStatut paiementStatut;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.demandeId)) {
        this.demandeId = data().deepCopy(fields()[1].schema(), other.demandeId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.montant)) {
        this.montant = data().deepCopy(fields()[2].schema(), other.montant);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.message)) {
        this.message = data().deepCopy(fields()[3].schema(), other.message);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.paiementStatut)) {
        this.paiementStatut = data().deepCopy(fields()[4].schema(), other.paiementStatut);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing PaiementCreateRequestAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.demandeId)) {
        this.demandeId = data().deepCopy(fields()[1].schema(), other.demandeId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.montant)) {
        this.montant = data().deepCopy(fields()[2].schema(), other.montant);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.message)) {
        this.message = data().deepCopy(fields()[3].schema(), other.message);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.paiementStatut)) {
        this.paiementStatut = data().deepCopy(fields()[4].schema(), other.paiementStatut);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'clientId' field.
      * @return The value.
      */
    public java.lang.String getClientId() {
      return clientId;
    }


    /**
      * Sets the value of the 'clientId' field.
      * @param value The value of 'clientId'.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder setClientId(java.lang.String value) {
      validate(fields()[0], value);
      this.clientId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'clientId' field has been set.
      * @return True if the 'clientId' field has been set, false otherwise.
      */
    public boolean hasClientId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'clientId' field.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder clearClientId() {
      clientId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'demandeId' field.
      * @return The value.
      */
    public java.lang.String getDemandeId() {
      return demandeId;
    }


    /**
      * Sets the value of the 'demandeId' field.
      * @param value The value of 'demandeId'.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder setDemandeId(java.lang.String value) {
      validate(fields()[1], value);
      this.demandeId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'demandeId' field has been set.
      * @return True if the 'demandeId' field has been set, false otherwise.
      */
    public boolean hasDemandeId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'demandeId' field.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder clearDemandeId() {
      demandeId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'montant' field.
      * @return The value.
      */
    public java.math.BigDecimal getMontant() {
      return montant;
    }


    /**
      * Sets the value of the 'montant' field.
      * @param value The value of 'montant'.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder setMontant(java.math.BigDecimal value) {
      validate(fields()[2], value);
      this.montant = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'montant' field has been set.
      * @return True if the 'montant' field has been set, false otherwise.
      */
    public boolean hasMontant() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'montant' field.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder clearMontant() {
      montant = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'message' field.
      * @return The value.
      */
    public java.lang.String getMessage() {
      return message;
    }


    /**
      * Sets the value of the 'message' field.
      * @param value The value of 'message'.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder setMessage(java.lang.String value) {
      validate(fields()[3], value);
      this.message = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'message' field has been set.
      * @return True if the 'message' field has been set, false otherwise.
      */
    public boolean hasMessage() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'message' field.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder clearMessage() {
      message = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'paiementStatut' field.
      * @return The value.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementStatut getPaiementStatut() {
      return paiementStatut;
    }


    /**
      * Sets the value of the 'paiementStatut' field.
      * @param value The value of 'paiementStatut'.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder setPaiementStatut(com.ecole221.prestation.kafka.avro.model.PaiementStatut value) {
      validate(fields()[4], value);
      this.paiementStatut = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'paiementStatut' field has been set.
      * @return True if the 'paiementStatut' field has been set, false otherwise.
      */
    public boolean hasPaiementStatut() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'paiementStatut' field.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.PaiementCreateRequestAvroModel.Builder clearPaiementStatut() {
      paiementStatut = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PaiementCreateRequestAvroModel build() {
      try {
        PaiementCreateRequestAvroModel record = new PaiementCreateRequestAvroModel();
        record.clientId = fieldSetFlags()[0] ? this.clientId : (java.lang.String) defaultValue(fields()[0]);
        record.demandeId = fieldSetFlags()[1] ? this.demandeId : (java.lang.String) defaultValue(fields()[1]);
        record.montant = fieldSetFlags()[2] ? this.montant : (java.math.BigDecimal) defaultValue(fields()[2]);
        record.message = fieldSetFlags()[3] ? this.message : (java.lang.String) defaultValue(fields()[3]);
        record.paiementStatut = fieldSetFlags()[4] ? this.paiementStatut : (com.ecole221.prestation.kafka.avro.model.PaiementStatut) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PaiementCreateRequestAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<PaiementCreateRequestAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PaiementCreateRequestAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<PaiementCreateRequestAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










