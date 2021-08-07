import { Module } from "@nestjs/common";
import { MongooseModule } from "@nestjs/mongoose";
import { PersonsModule } from "./person/person.module";

@Module({
  imports: [
    MongooseModule.forRoot("mongodb://host.docker.internal:27017/people"),
    PersonsModule,
  ],
})
export class AppModule {}
