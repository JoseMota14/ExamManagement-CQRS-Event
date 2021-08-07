import { Module } from "@nestjs/common";
import { MongooseModule } from "@nestjs/mongoose";
import { PersonsController } from "./person.controller";
import { PersonsService } from "./person.service";
import { Person, PersonSchema } from "./schemas/person.schema";
import { ScheduleModule } from "@nestjs/schedule";

@Module({
  imports: [
    MongooseModule.forFeature([{ name: Person.name, schema: PersonSchema }]),
    ScheduleModule.forRoot(),
  ],
  controllers: [PersonsController],
  providers: [PersonsService],
})
export class PersonsModule {}
