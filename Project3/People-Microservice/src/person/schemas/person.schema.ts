import { Prop, Schema, SchemaFactory } from "@nestjs/mongoose";
import { Document } from "mongoose";
import { Role } from "../enum/role.enum";

export type PersonDocument = Person & Document;

@Schema()
export class Person {
  @Prop({ type: String, required: true })
  name: string;

  @Prop({ type: String, default: "Por definir" })
  role: string;

  @Prop({ type: Boolean, default: true })
  isActive: boolean;

  @Prop({ type: Date, default: new Date() })
  createdAt: Date;
}

export const PersonSchema = SchemaFactory.createForClass(Person);
