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
public class CustomerCreateResponseAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7133032462531785463L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CustomerCreateResponseAvroModel\",\"namespace\":\"com.ecole221.prestation.kafka.avro.model\",\"fields\":[{\"name\":\"clientId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"message\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"customerStatut\",\"type\":{\"type\":\"enum\",\"name\":\"CustomerStatut\",\"symbols\":[\"CREATED\",\"EXIST\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CustomerCreateResponseAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CustomerCreateResponseAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CustomerCreateResponseAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CustomerCreateResponseAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CustomerCreateResponseAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CustomerCreateResponseAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CustomerCreateResponseAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CustomerCreateResponseAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CustomerCreateResponseAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String clientId;
  private java.lang.String message;
  private com.ecole221.prestation.kafka.avro.model.CustomerStatut customerStatut;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CustomerCreateResponseAvroModel() {}

  /**
   * All-args constructor.
   * @param clientId The new value for clientId
   * @param message The new value for message
   * @param customerStatut The new value for customerStatut
   */
  public CustomerCreateResponseAvroModel(java.lang.String clientId, java.lang.String message, com.ecole221.prestation.kafka.avro.model.CustomerStatut customerStatut) {
    this.clientId = clientId;
    this.message = message;
    this.customerStatut = customerStatut;
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
    case 1: return message;
    case 2: return customerStatut;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: clientId = value$ != null ? value$.toString() : null; break;
    case 1: message = value$ != null ? value$.toString() : null; break;
    case 2: customerStatut = (com.ecole221.prestation.kafka.avro.model.CustomerStatut)value$; break;
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
   * Gets the value of the 'customerStatut' field.
   * @return The value of the 'customerStatut' field.
   */
  public com.ecole221.prestation.kafka.avro.model.CustomerStatut getCustomerStatut() {
    return customerStatut;
  }


  /**
   * Sets the value of the 'customerStatut' field.
   * @param value the value to set.
   */
  public void setCustomerStatut(com.ecole221.prestation.kafka.avro.model.CustomerStatut value) {
    this.customerStatut = value;
  }

  /**
   * Creates a new CustomerCreateResponseAvroModel RecordBuilder.
   * @return A new CustomerCreateResponseAvroModel RecordBuilder
   */
  public static com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder newBuilder() {
    return new com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder();
  }

  /**
   * Creates a new CustomerCreateResponseAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CustomerCreateResponseAvroModel RecordBuilder
   */
  public static com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder newBuilder(com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder other) {
    if (other == null) {
      return new com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder();
    } else {
      return new com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new CustomerCreateResponseAvroModel RecordBuilder by copying an existing CustomerCreateResponseAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new CustomerCreateResponseAvroModel RecordBuilder
   */
  public static com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder newBuilder(com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel other) {
    if (other == null) {
      return new com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder();
    } else {
      return new com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for CustomerCreateResponseAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CustomerCreateResponseAvroModel>
    implements org.apache.avro.data.RecordBuilder<CustomerCreateResponseAvroModel> {

    private java.lang.String clientId;
    private java.lang.String message;
    private com.ecole221.prestation.kafka.avro.model.CustomerStatut customerStatut;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.message)) {
        this.message = data().deepCopy(fields()[1].schema(), other.message);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.customerStatut)) {
        this.customerStatut = data().deepCopy(fields()[2].schema(), other.customerStatut);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing CustomerCreateResponseAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.message)) {
        this.message = data().deepCopy(fields()[1].schema(), other.message);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.customerStatut)) {
        this.customerStatut = data().deepCopy(fields()[2].schema(), other.customerStatut);
        fieldSetFlags()[2] = true;
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
    public com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder setClientId(java.lang.String value) {
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
    public com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder clearClientId() {
      clientId = null;
      fieldSetFlags()[0] = false;
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
    public com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder setMessage(java.lang.String value) {
      validate(fields()[1], value);
      this.message = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'message' field has been set.
      * @return True if the 'message' field has been set, false otherwise.
      */
    public boolean hasMessage() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'message' field.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder clearMessage() {
      message = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerStatut' field.
      * @return The value.
      */
    public com.ecole221.prestation.kafka.avro.model.CustomerStatut getCustomerStatut() {
      return customerStatut;
    }


    /**
      * Sets the value of the 'customerStatut' field.
      * @param value The value of 'customerStatut'.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder setCustomerStatut(com.ecole221.prestation.kafka.avro.model.CustomerStatut value) {
      validate(fields()[2], value);
      this.customerStatut = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'customerStatut' field has been set.
      * @return True if the 'customerStatut' field has been set, false otherwise.
      */
    public boolean hasCustomerStatut() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'customerStatut' field.
      * @return This builder.
      */
    public com.ecole221.prestation.kafka.avro.model.CustomerCreateResponseAvroModel.Builder clearCustomerStatut() {
      customerStatut = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CustomerCreateResponseAvroModel build() {
      try {
        CustomerCreateResponseAvroModel record = new CustomerCreateResponseAvroModel();
        record.clientId = fieldSetFlags()[0] ? this.clientId : (java.lang.String) defaultValue(fields()[0]);
        record.message = fieldSetFlags()[1] ? this.message : (java.lang.String) defaultValue(fields()[1]);
        record.customerStatut = fieldSetFlags()[2] ? this.customerStatut : (com.ecole221.prestation.kafka.avro.model.CustomerStatut) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CustomerCreateResponseAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<CustomerCreateResponseAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CustomerCreateResponseAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<CustomerCreateResponseAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.clientId);

    out.writeString(this.message);

    out.writeEnum(this.customerStatut.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.clientId = in.readString();

      this.message = in.readString();

      this.customerStatut = com.ecole221.prestation.kafka.avro.model.CustomerStatut.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.clientId = in.readString();
          break;

        case 1:
          this.message = in.readString();
          break;

        case 2:
          this.customerStatut = com.ecole221.prestation.kafka.avro.model.CustomerStatut.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









