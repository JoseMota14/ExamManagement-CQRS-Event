import { Injectable, UnprocessableEntityException } from "@nestjs/common";
import { InjectModel } from "@nestjs/mongoose";
import { Model } from "mongoose";
import { CreatePersonDto } from "./dto/create-person.dto";
import { UpdatePersonDto } from "./dto/update-person.dto";
import { Role } from "./enum/role.enum";
import { Person, PersonDocument } from "./schemas/person.schema";

@Injectable()
export class PersonsService {
  constructor(
    @InjectModel(Person.name)
    private readonly personModel: Model<PersonDocument>
  ) {}

  async create(createPersonDto: CreatePersonDto): Promise<Person> {
    const createdPerson = new this.personModel(createPersonDto);
    return createdPerson.save();
  }

  async findAll(): Promise<Person[]> {
    return this.personModel.find().exec();
  }

  async updateRole(id: string, updateRoleDto: UpdatePersonDto): Promise<any> {
    if (!(updateRoleDto.role.toUpperCase() in Role)) {
      throw new UnprocessableEntityException("Invalid role!");
    }
    return this.personModel
      .updateOne(
        { _id: id },
        { $set: { role: updateRoleDto.role.toUpperCase() } }
      )
      .exec();
  }

  async setPersonInactive(id: string): Promise<any> {
    return this.personModel
      .updateOne({ _id: id }, { $set: { isActive: true } })
      .exec();
  }

  async updateStudentsActivity(): Promise<void> {
    this.personModel
      .updateMany({ role: /^estudante$/i }, { $set: { isActive: false } })
      .exec();
  }
}
