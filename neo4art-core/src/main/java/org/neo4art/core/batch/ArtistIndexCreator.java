/**
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.neo4art.core.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4art.core.repository.ArtistBatchInserterRepository;
import org.neo4art.core.repository.ArtistRepository;
import org.neo4art.graphdb.connection.Neo4ArtBatchInserterSingleton;

/**
 * @author Lorenzo Speranzoni
 * @since 3 May 2015
 */
public class ArtistIndexCreator
{
  private static Log logger = LogFactory.getLog(ArtistIndexCreator.class);
  
  public static void main(String[] args)
  {
    try
    {
      ArtistRepository artistRepository = new ArtistBatchInserterRepository();
      
      artistRepository.createArtistLegacyIndex();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      logger.error("Error creating legacy index for artists: " + e.getMessage());
    }
    finally
    {
      Neo4ArtBatchInserterSingleton.shutdownBatchInserterInstance();
    }
  }
}
