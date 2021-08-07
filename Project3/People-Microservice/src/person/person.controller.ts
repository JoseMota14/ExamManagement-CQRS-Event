import { Body, Controller, Get, Param, Post, Put } from "@nestjs/common";
import { PersonsService } from "./person.service";
import { CreatePersonDto } from "./dto/create-person.dto";
import { Person } from "./schemas/person.schema";
import { UpdatePersonDto } from "./dto/update-person.dto";
import { Cron } from "@nestjs/schedule";
@Controller("persons")
export class PersonsController {
  constructor(private readonly personsService: PersonsService) {}

  @Post()
  async create(@Body() createPersonDto: CreatePersonDto) {
    await this.personsService.create(createPersonDto);
  }

  @Get()
  async findAll(): Promise<Person[]> {
    return this.personsService.findAll();
  }

  @Put(":id")
  async updateRole(
    @Param("id") id: string,
    @Body() updatePersonDto: UpdatePersonDto
  ): Promise<Person[]> {
    return this.personsService.updateRole(id, updatePersonDto);
  }

  @Put("inactive/:id")
  async setInactivity(@Param("id") id: string): Promise<Person[]> {
    return this.personsService.setPersonInactive(id);
  }

  /*   @Cron("45 * * * * *") */
  @Cron("0 0 1 8 *") // 1 de Agosto
  handleCron(): void {
    console.log("-- Updating all students activity --");
    this.personsService.updateStudentsActivity();
  }
}
